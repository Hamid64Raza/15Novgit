package com.finalgateturtorial.servicetest;

import com.finalgateturtorial.repository.EmpRepository;
import com.finalgateturtorial.service.EmpServiceClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private EmpRepository empRepository;

    @InjectMocks
    private EmpServiceClass empServiceClass;



}
