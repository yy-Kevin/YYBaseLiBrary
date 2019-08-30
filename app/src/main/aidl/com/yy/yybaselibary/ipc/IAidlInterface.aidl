// IAidlInterface.aidl
package com.yy.yybaselibary.ipc;

// Declare any non-default types here with import statements
import com.yy.yybaselibary.ipc.Fruit;

interface IAidlInterface {
    void addFruit(in Fruit fruit);
    List<Fruit> getFruitList();
}
