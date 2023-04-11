package com.xkk.mango.admin.security;

import com.xkk.mango.admin.model.SysUser;
import com.xkk.mango.admin.service.SysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户登录认证信息查询
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 用户权限列表，根据权限表示如@PreAuthorize("hasAuthority('sys:menu:view')")
        // 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(user.getName());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
    }
}
