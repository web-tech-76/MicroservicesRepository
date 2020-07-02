package bank.service.delegates;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		return Optional.of("user");
				
				//Optional.ofNullable(
				//((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
	}

}
