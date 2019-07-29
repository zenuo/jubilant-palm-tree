package demo.service;

import demo.model.Customer;

public interface CustomerService {
    Customer get(Long id);
    void updateWithoutRefresh(Long id);
    void updateWithRefresh(Long id);
}
