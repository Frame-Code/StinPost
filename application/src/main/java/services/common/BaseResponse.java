package services.common;

public record BaseResponse<T>(
        boolean isSuccessfully,
        String message,
        T data) {}
