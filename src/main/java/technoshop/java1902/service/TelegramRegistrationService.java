package technoshop.java1902.service;

import technoshop.java1902.entity.TelegramRegistration;

import java.util.List;

public interface TelegramRegistrationService {
    List<TelegramRegistration> getAll();
    TelegramRegistration getById(Long id);
    TelegramRegistration create(TelegramRegistration telegramRegistration);
    TelegramRegistration deleteById(Long id);
}
