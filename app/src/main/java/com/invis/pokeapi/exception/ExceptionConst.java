package com.invis.pokeapi.exception;

public class ExceptionConst extends IllegalStateException {
       // public static final String USERS_PATH = Resources.API_PREFIX + "users";
        public static final String ILLEGAL_ARGUMENT_ERROR_STATUS="ILLEGAL_ARGUMENT_ERROR";
        public static final String UNEXPECTED_ERROR_STATUS = "UNEXPECTED_ERROR";
        public static final String UNEXPECTED_ERROR_MESSAGE="Unexpected Error in method";
        public static final String NON_VALID_ERROR_STATUS ="NON_VALID_ERROR";
        public static final String NON_VALID_ERROR_MESSAGE ="Данная сессия была завершена." +
                " Повторите авторизацию";
        //Не уверен что фронту вообще это надо (может удалить где иименно возник нул?
        public static final String NULL_POINTER_EXCEPTION_STATUS ="NULL_POINTER_EXCEPTION";
        public static final String NULL_POINTER_EXCEPTION_MESSAGE = "Тело запроса " +
                "отсутствует или некорректно";

 public ExceptionConst(String masage) {
  super(masage);
 }
}
