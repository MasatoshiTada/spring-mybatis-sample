package com.example;

import com.example.persistence.config.DataSourceConfig;
import com.example.persistence.config.MyBatisConfig;
import com.example.persistence.entity.Customer;
import com.example.service.CustomerService;
import com.example.service.config.ServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, MyBatisConfig.class, ServiceConfig.class);
        CustomerService customerService = context.getBean(CustomerService.class);

        // 追加前
        System.out.println("=========== 追加前 ============");
        List<Customer> customerListBefore = customerService.findAll();
        for (Customer customer : customerListBefore) {
            System.out.println(customer);
        }

        // 追加処理
        System.out.println("=========== 追加処理 ============");
        customerService.insert(new Customer("史帆", "加藤", "kato@hinata.com", LocalDate.of(1998, 2, 2)));

        // 追加後
        System.out.println("=========== 追加後 ============");
        List<Customer> customerListAfter = customerService.findAll();
        for (Customer customer : customerListAfter) {
            System.out.println(customer);
        }

        // ID検索
        System.out.println("=========== ID検索 ============");
        Optional<Customer> customerOptional = customerService.findById(6);
        if (customerOptional.isPresent()) {
            System.out.println(customerOptional.get());
        } else {
            System.out.println("id = 6は存在しません");
        }
    }
}
