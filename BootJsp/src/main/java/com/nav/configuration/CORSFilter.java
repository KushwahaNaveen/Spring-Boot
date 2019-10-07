package com.nav.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.logging.log4j.LogManager;


public class CORSFilter implements Filter {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(CORSFilter.class);
   
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        CharResponseWrapper wrappedResponse = new CharResponseWrapper((HttpServletResponse) response);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
        response.setHeader("Access-Control-Max-Age", "900");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Authorization,X-Client-Header");

        String url = ((HttpServletRequest) httpRequest).getRequestURL().toString();
        /*if ((url.contains("rest") || url.contains("open") || url.contains("agent")) && !url.contains("rest/image") && !url.contains("open/getvirtualCard") && !url.contains("rest/getvirtualCard")

                && !url.contains("open/getvirtualCardMultiple") && !url.contains("open/restpps")) {

            // log.info("inside encryption response");

            chain.doFilter(req, wrappedResponse);

            byte[] bytes = wrappedResponse.getByteArray();

            if (httpRequest instanceof HttpServletRequest) {

                if (url.contains("rest") || url.contains("open") || url.contains("agent")) {

                    try {

                        String str = new String(bytes);

                        res.getOutputStream().write(AESEncryption.encryptUsingKey(str, AESEncryption.decryptMessageFromStringKey(httpRequest.getHeader("X-Client-Header"))).getBytes());

                    } catch (Exception e) {

                        e.printStackTrace();

                        log.info("Exception while encrypting data:" + e.getMessage());

                    }

                }

            }

        } else {

            chain.doFilter(new XSSRequestWrapper((HttpServletRequest) req), res);

        }*/

        System.err.println("inside filter");
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) req), res);

    }

    @Override

    public void init(FilterConfig filterConfig) {

    }

    @Override

    public void destroy() {

    }

    private static class ByteArrayServletStream extends ServletOutputStream {

        ByteArrayOutputStream baos;

        ByteArrayServletStream(ByteArrayOutputStream baos) {

            this.baos = baos;

        }

        public void write(int param) throws IOException {

            baos.write(param);

        }

        @Override

        public boolean isReady() {

            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

        @Override

        public void setWriteListener(WriteListener writeListener) {

            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    }

    private static class ByteArrayPrintWriter {

        private ByteArrayOutputStream baos = new ByteArrayOutputStream();

        private PrintWriter pw = new PrintWriter(baos);

        private ServletOutputStream sos = new ByteArrayServletStream(baos);

        public PrintWriter getWriter() {

            return pw;

        }

        public ServletOutputStream getStream() {

            return sos;

        }

        byte[] toByteArray() {

            return baos.toByteArray();

        }

    }

    public class CharResponseWrapper extends HttpServletResponseWrapper {

        private ByteArrayPrintWriter output;

        private boolean usingWriter;

        public CharResponseWrapper(HttpServletResponse response) {

            super(response);

            usingWriter = false;

            output = new ByteArrayPrintWriter();

        }

        public byte[] getByteArray() {

            return output.toByteArray();

        }

        @Override

        public ServletOutputStream getOutputStream() throws IOException {

            // will error out, if in use

            if (usingWriter) {

                super.getOutputStream();

            }

            usingWriter = true;

            return output.getStream();

        }

        @Override

        public PrintWriter getWriter() throws IOException {

            // will error out, if in use

            if (usingWriter) {

                super.getWriter();

            }

            usingWriter = true;

            return output.getWriter();

        }

        public String toString() {

            return output.toString();

        }

    }

}
