package com.springsecurity.app;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * AppErrorAttributes class
 *
 * @author BGH58082
 */
@Component
public class AppErrorAttributes extends DefaultErrorAttributes {
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public AppErrorAttributes() {
        super();
    }

//    @Override
//    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
//        var errorAttributes = super.getErrorAttributes(request, false);
//        var error = getError(request);
//
//        var errorList = new ArrayList<Map<String, Object>>();
//
//        if (error instanceof AuthException || error instanceof UnauthorizedException) {
//            status = HttpStatus.UNAUTHORIZED;
//            var errorMap = new LinkedHashMap<String, Object>();
//            errorMap.put("code", ((ApiException) error).getErrorCode());
//            errorMap.put("message", error.getMessage());
//            errorList.add(errorMap);
//        } else if (error instanceof ApiException) {
//            status = HttpStatus.BAD_REQUEST;
//            var errorMap = new LinkedHashMap<String, Object>();
//            errorMap.put("code", ((ApiException) error).getErrorCode());
//            errorMap.put("message", error.getMessage());
//            errorList.add(errorMap);
//        } else if (error instanceof ExpiredJwtException || error instanceof SignatureException || error instanceof MalformedJwtException) {
//            status = HttpStatus.UNAUTHORIZED;
//            var errorMap = new LinkedHashMap<String, Object>();
//            errorMap.put("code", "UNAUTHORIZED");
//            errorMap.put("message", error.getMessage());
//            errorList.add(errorMap);
//        } else {
//            status = HttpStatus.INTERNAL_SERVER_ERROR;
//            var message = error.getMessage();
//            if (message == null)
//                message = error.getClass().getName();
//
//            var errorMap = new LinkedHashMap<String, Object>();
//            errorMap.put("code", "INTERNAL_ERROR");
//            errorMap.put("message", message);
//            errorList.add(errorMap);
//        }
//
//        var errors = new HashMap<String, Object>();
//        errors.put("errors", errorList);
//        errorAttributes.put("status", status.value());
//        errorAttributes.put("errors", errors);
//
//        return errorAttributes;
//    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

