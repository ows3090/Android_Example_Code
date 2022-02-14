//
// Created by 오원석 on 2022/02/14.
//


#include "calculator.h"

JNIEXPORT jint JNICALL Java_ows_kotlinstudy_ndk_1build_MainActivity_plus(JNIEnv *env, jobject thiz, jint num1, jint num2){
    return num1 + num2;
}

JNIEXPORT jint JNICALL Java_ows_kotlinstudy_ndk_1build_MainActivity_minus(JNIEnv *env, jobject thiz, int num1, int num2){
    return num1 + num2;
}

JNIEXPORT jint JNICALL Java_ows_kotlinstudy_ndk_1build_MainActivity_multi(JNIEnv *env, jobject thiz,int num1, int num2){
    return num1*num2;
}

JNIEXPORT jdouble JNICALL Java_ows_kotlinstudy_ndk_1build_MainActivity_div(JNIEnv *env, jobject thiz, int num1, int num2){
    if(num2 == 0) return -1;
    else return (double)num1/num2;
}