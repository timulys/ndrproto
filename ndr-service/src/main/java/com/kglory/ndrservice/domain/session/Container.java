package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Container
 * Author 		: jhchoi
 * Date 		: 2023-08-03
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-03			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {
	private String id;
	private String name;
	private String runtime;
	private String imageName;
	private String[] imageTags;

	@SuppressWarnings("unchecked")
	@JsonProperty("image")
	private void unpackClient(Map<String, Object> image) {
		this.imageName = (String) image.get("name");
		this.imageTags = (String[]) image.get("tag");
	}
}
