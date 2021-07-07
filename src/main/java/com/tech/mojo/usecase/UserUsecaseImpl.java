package com.tech.mojo.usecase;

import com.tech.mojo.domain.User;
import com.tech.mojo.utils.MojoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class UserUsecaseImpl implements UserUsecase {

    @Value("${access.count}")
    private String count;
    @Value("${access.limit}")
    private String limit;

    @Override
    public User isAccessable(User user) {
        LocalTime enableTime = user.getEnableTime();
        LocalTime endTime=enableTime.plusHours(Integer.valueOf(limit));
        int requestCount = user.getRequestCount();
        if (endTime.isAfter(LocalTime.now())){
            if(requestCount>=Integer.valueOf(count)){
                throw new MojoException("User limit over please try after some time");
            }
            user.setRequestCount(requestCount+1);
            return user;
        }else {
            user.setEnableTime(LocalTime.now());
            user.setRequestCount(0);
        }
        return user;
    }
}
