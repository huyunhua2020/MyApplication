//
// Created by Administrator on 2020/4/20.
//
#include "com_example_myapplication_MainActivity.h"
JNIEXPORT jstring JNICALL Java_com_example_myapplication_MainActivity_testJNI(JNIEnv *env, jobject obj){
    return (*env)->NewStringUTF(env, "NDK HELLO");
}

JNIEXPORT jstring JNICALL Java_com_example_myapplication_MainActivity_getJNIString
  (JNIEnv *env, jclass jclz) {
  return  (*env)->NewStringUTF(env, "getJNIString NDK HELLO");
}
