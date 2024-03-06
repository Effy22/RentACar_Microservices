package com.elif.constant;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";

    private static final String ROOT = DEV + VERSION;
    public static final String VEHICLE = ROOT + "/vehicle";
    public static final String RENTING = ROOT + "/renting";

    public static final String REQUEST_RENTING = "/request-renting";
    public static final String CANCEL_RENTING = "/cancel-renting";
    public static final String FIND_BY_TOKEN = "/find-by-token";
    public static final String GET_BALANCE = "/get-balance";
    public static final String UPDATE = "/update";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id";

}
