package spittr.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spittr.data.SpittleRepository;
import spittr.model.Spitter;

import java.util.ArrayList;
import java.util.List;

public class SpitterUserService implements UserDetailsService {

    private final SpittleRepository spittleRepository;

    public SpitterUserService(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Spitter spitter = spittleRepository.findByUsername("");
        if (spitter != null) {
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            return new User(spitter.getUsername(), spitter.getPassword(), authorityList);
        }
        throw new UsernameNotFoundException("");
    }
}
