LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := circuitcu
LOCAL_SRC_FILES := circuitcu.cpp

include $(BUILD_SHARED_LIBRARY)
