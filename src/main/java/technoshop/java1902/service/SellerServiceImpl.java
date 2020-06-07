package technoshop.java1902.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technoshop.java1902.entity.Seller;
import technoshop.java1902.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Override
    public Seller create(Seller seller) {
        return sellerRepository.save(seller);

    }
}
