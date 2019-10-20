package com.pprokurat.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error: folder with provided ID not found")
public class FolderNotFoundException extends RuntimeException {
}