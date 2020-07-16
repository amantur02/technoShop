package technoshop.java1902.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technoshop.java1902.entity.TelegramRegistration;
import technoshop.java1902.repository.TelegramRegistrationRepository;

import java.util.List;

@Service
public class TelegramRegistrationServiceImpl implements TelegramRegistrationService {
    @Autowired
    private TelegramRegistrationRepository telegramRegistrationRepository;
    @Override
    public List<TelegramRegistration> getAll() {
        return telegramRegistrationRepository.findAll();
    }

    @Override
    public TelegramRegistration getById(Long id) {
        return telegramRegistrationRepository.findById(id).orElse(null);
    }

    @Override
    public TelegramRegistration create(TelegramRegistration telegramRegistration) {
        return telegramRegistrationRepository.save(telegramRegistration);
    }

    @Override
    public TelegramRegistration deleteById(Long id) {
        TelegramRegistration telegramRegistration = getById(id);
        if (telegramRegistration != null) {
            telegramRegistrationRepository.deleteById(id);
        }
        return telegramRegistration;
    }
}
