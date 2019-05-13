package com.yupaopao.animation.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @Description: ByteBufferWriter
 * @Author: pengfei.zhou
 * @CreateDate: 2019-05-12
 */
public class ByteBufferWriter implements Writer {

    private ByteBuffer byteBuffer;

    public ByteBufferWriter() {
        reset(10 * 1024);
    }

    @Override
    public void putByte(byte b) {
        byteBuffer.put(b);
    }

    @Override
    public void putBytes(byte[] b) {
        byteBuffer.put(b);
    }

    @Override
    public int position() {
        return byteBuffer.position();
    }

    @Override
    public byte[] toByteArray() {
        return byteBuffer.array();
    }

    @Override
    public void close() {
    }

    @Override
    public void reset(int size) {
        if (byteBuffer == null || size > byteBuffer.limit()) {
            byteBuffer = ByteBuffer.allocate(size);
            this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        byteBuffer.clear();
    }
}