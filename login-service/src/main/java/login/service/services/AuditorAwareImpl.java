package login.service.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		return Optional.of("user1");
				
				//Optional.ofNullable(
				//((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
	}

}
