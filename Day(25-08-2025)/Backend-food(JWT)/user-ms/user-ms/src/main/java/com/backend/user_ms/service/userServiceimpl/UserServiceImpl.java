package com.backend.user_ms.service.userServiceimpl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.backend.user_ms.dto.Token;
import com.backend.user_ms.entity.User;
import com.backend.user_ms.repository.UserRepository;
import com.backend.user_ms.service.UserService;
import com.backend.user_ms.util.AppConstant;
import com.backend.user_ms.util.EncryptUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		
		Optional<User>optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
		return null;
		}
	}

	@Override
	 @Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		String password = user.getPassWord();
		String[] passWordSalt = EncryptUtil.getEncryptedPassword(password, null);
		user.setPassWord(passWordSalt[0]);
		user.setSalt(passWordSalt[1]);		
		userRepo.save(user);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);

	}

	@Override
	public Token login(User user) {
		// TODO Auto-generated method stub
		User userSalt = userRepo.findByUserEmail(user.getUserEmail());
		
		String[] encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassWord(), userSalt.getSalt());
		
		User userData = userRepo.findByUserEmailAndPassWord(user.getUserEmail(), encryptedPassword[0]);
		if(userData!=null) {
			System.out.println(getJWTToken(userData.getUserEmail())); 
			String jwtToken="Bearer " + getJWTToken(user.getUserEmail());
			System.out.println("token="+jwtToken);
			Token token=new Token();
			token.setToken(jwtToken);
			return token;
		}
		return null;
	}
	
	 private String getJWTToken(String username) {
	        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
		 	List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

	        return Jwts.builder()
	                .setId("jwtExample")
	                .setSubject(username)
	                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))
	                .signWith(key)
	                .compact();
	    }

}