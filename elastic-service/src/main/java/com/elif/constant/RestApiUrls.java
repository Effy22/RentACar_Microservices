package com.elif.constant;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String ELASTIC = "/elastic";

    private static final String ROOT = DEV + VERSION + ELASTIC;
    public static final String VEHICLE = ROOT + "/vehicle";
    public static final String RENTING = ROOT + "/renting";

    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String DELETE_BY_TOKEN = "/delete-by-token";
    public static final String FIND_BY_ID = "/find-by-id";
    public static final String FIND_ALL = "/find-all";
    public static final String FIND_BY_MODEL = "/find-by-model";
    public static final String ACTIVATE_STATUS = "/activate-status";
    public static final String FIND_BY_ROLE = "/find-by-role";

}
