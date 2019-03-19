package com.akadamie.cosmitapp.commons;


import org.springframework.stereotype.Component;


public interface Mapper<F, T> {
    T map(F from);

    F reverse(T to);
}
