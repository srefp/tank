package com.mashibing.test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ImageTest {

    @Test
    public void test() {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\gitRepos\\github\\tank\\tank_mashibing\\src\\images\\bulletD.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
