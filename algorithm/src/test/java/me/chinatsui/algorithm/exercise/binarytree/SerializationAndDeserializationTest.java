package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class SerializationAndDeserializationTest {

    private SerializationDeserialization sad = new SerializationDeserialization();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{1, 2, 3});
        String content = sad.serialize(root);
        Assert.assertEquals("1,2,N,N,3,N,N", content);
        TreeNode node = sad.deserialize(content);
        Assert.assertEquals(root.val, node.val);
        Assert.assertEquals(root.left.val, node.left.val);
        Assert.assertEquals(root.right.val, node.right.val);
    }
}
