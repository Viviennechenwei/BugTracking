package com.vivi.bugTracking.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("do set up http response header.");
        HttpServletResponse resp = (HttpServletResponse) response;
        //https://blog.csdn.net/zmx729618/article/details/80825586
        //Preflighted requests:"preflighted" requests first send an HTTP request by the OPTIONS method to the resource on the other domain, in order to determine whether the actual request is safe to send.
        //When a request is preflighted:
        /**
         * //https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
         * In particular, a request is preflighted if any of the following conditions is true:
         *
         * If the request uses any of the following methods:
         * PUT
         * DELETE
         * CONNECT
         * OPTIONS
         * TRACE
         * PATCH
         * Or if, apart from the headers set automatically by the user agent (for example, Connection, User-Agent, or any of the other header with a name defined in the Fetch spec as a “forbidden header name”), the request includes any headers other than those which the Fetch spec defines as being a “CORS-safelisted request-header”, which are the following:
         * Accept
         * Accept-Language
         * Content-Language
         * Content-Type (but note the additional requirements below)
         * DPR
         * Downlink
         * Save-Data
         * Viewport-Width
         * Width
         * Or if the Content-Type header has a value other than the following:
         * application/x-www-form-urlencoded
         * multipart/form-data
         * text/plain
         * Or if one or more event listeners are registered on an XMLHttpRequestUpload object used in the request.
         * Or if a ReadableStream object is used in the request.
         */
        //when credentials used in request header, then  Access-Control-Allow-Origin must not use *. You will have to specify the exact protocol + domain + port. For reference see these questions
        //https://stackoverflow.com/questions/14003332/access-control-allow-origin-wildcard-subdomains-ports-and-protocols
        //https://stackoverflow.com/questions/8074665/cross-origin-resource-sharing-with-credentials
        //https://stackoverflow.com/questions/19743396/cors-cannot-use-wildcard-in-access-control-allow-origin-when-credentials-flag-i
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4201");//TODO: change this
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, X-Requested-With, accept, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        resp.setHeader("Access-Control-Expose-Headers",
                "Origin, Access-Control-Request-Method, Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        resp.setHeader("Access-Control-Max-Age", "4000");
        //https://howtodoinjava.com/servlets/java-cors-filter-example/
        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
        chain.doFilter(request, resp);
    }

    @Override
    public void destroy() {

    }
}
