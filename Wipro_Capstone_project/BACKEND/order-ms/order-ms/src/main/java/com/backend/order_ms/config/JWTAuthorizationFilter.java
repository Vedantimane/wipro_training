package com.backend.order_ms.config;


import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.order_ms.util.AppConstant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";

    // Public endpoints for order_ms (no token needed)
    private final List<String> PUBLIC_ENDPOINTS = List.of(
            "/user/login",
            "/user/register"
           
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (PUBLIC_ENDPOINTS.contains(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            if (checkJWTToken(request)) {
                Claims claims = validateToken(request);
                if (claims.get("authorities") != null) {
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }

            filterChain.doFilter(request, response);

        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
        }
    }

    // ---------------- Helpers ----------------
    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(
                        claims.getSubject(), null,
                        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                );

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean checkJWTToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HEADER);
        return authHeader != null && authHeader.startsWith(PREFIX);
    }
}