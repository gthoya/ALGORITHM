package gthoya.algorithm.tree;

import gthoya.algorithm.tree.model.Node;

public interface Tree {
    void insertNode();

    void updateNode();

    void deleteNode();

    Node searchNode();

    void printAll();
}
