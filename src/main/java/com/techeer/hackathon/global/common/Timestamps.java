package com.techeer.hackathon.global.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우, 데이터 트래킹 필드로 인식
@EntityListeners(AuditingEntityListener.class) //Entity Listener는 엔티티의 변화를 감지하고 데이블의 데이터를 조작하는 일을 한다
@Getter
public class Timestamps {
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime deletedAt = LocalDateTime.now();
}