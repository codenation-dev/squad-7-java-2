package com.codenation.centralerros.dto;

import java.time.LocalDateTime;

import com.codenation.centralerros.model.LogDetail;
import com.codenation.centralerros.model.enums.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDetailDTO {

    private Long id;
    private String title;
    private String detail;
    private String level;
    private String environment;
    private Boolean archived;
	private LocalDateTime timeEvent;
	private LocalDateTime createdDate;
	private LocalDateTime createdBy;

	public LogDetailDTO(LogDetail logDetail) {
		title = logDetail.getTitle();
		detail = logDetail.getDetail();
		level = logDetail.getLevel().toString();
		archived = logDetail.getArchived();
		timeEvent = logDetail.getTimeEvent();
	}

	public LogDetail toLogDetail() {
		return LogDetail.builder()
				.archived( archived )
				.detail( detail )
				.level( Level.valueOf( level ) )
				.timeEvent( LocalDateTime.now() )
				.build();
	}
}