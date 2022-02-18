#include <jni.h>
#include <string>


/*
 * JNI Naming
extern "C"
JNIEXPORT jint JNICALL
Java_ows_kotlinstudy_cmake_MainActivity_getSum(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return num1+num2;
}*/

jint getSum(JNIEnv *env, jobject thiz, jint num1, jint num2) {
    return num1 + num2;
}

jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    jclass c = env->FindClass("ows/kotlinstudy/cmake/MainActivity");
    if (c == nullptr) return JNI_ERR;

    static const JNINativeMethod methods[] = {
            {"getSum", "(II)I", (void *) getSum}
    };

    int rc = env->RegisterNatives(c, methods, sizeof(methods) / sizeof(JNINativeMethod));
    if (rc != JNI_OK) return rc;

    return JNI_VERSION_1_6;
}
