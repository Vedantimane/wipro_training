package com.backend.user_ms.service.userServiceimpl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.backend.user_ms.dto.Token;
import com.backend.user_ms.entity.User;
import com.backend.user_ms.repository.UserRepository;
import com.backend.user_ms.service.UserService;
import com.backend.user_ms.util.AppConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Service
public class UserServiceImpl implements UserService {
	
//	private static final String SECRET = "d3No4uat7HEgU6RHjJ902G+gTj3+qHNZZ/CN6BUeCa4cKFSkp1AGFXH7ODj3A+fPDf1WQB2x6Yknr6VFh5ySyw==";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        System.out.println("User created");
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            System.out.println("User found with id: " + id);
        } else {
            System.out.println("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public User update(User user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getUserId());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserPassword(user.getUserPassword());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
    }

    @Override
    public void deleteById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            System.out.println("User deleted with id: " + id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

	@Override
	public Token login(User user) {
		
		User userData = userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		
		if(userData != null) {
			System.out.println(getJWTToken(user.getUserEmail()));
			String jwtToken = "Bearer " + getJWTToken(user.getUserEmail());

			System.out.println("tokrn= "+jwtToken);
			Token token=new Token();
			token.setToken(jwtToken);
			return token;
		}
		// TODO Auto-generated method stub
		return null;
	}

	private String getJWTToken(String userName) {
	    Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
	 	List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
	 	  return Jwts.builder()
	                .setId("jwtExample")
	                .setSubject(userName)
	                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))
	                .signWith(key)
	                .compact();
		// TODO Auto-generated method stub
	
	}

//    @Override
//    public User findByEmailAndPassword(String userEmail, String userPassword) {
//        return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
//    }
    
    
}
