package com.spring.boot.es;

import com.spring.boot.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 2017/4/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class test {

    List mocklist = null;

    @Before
    public void InitMethod(){
        mocklist = mock(List.class);
    }

    @Test
    public void test(){
//        验证行为
//        mock creat
        List mlist = mock(List.class);
//        using mock
        mlist.add(1);
        mlist.clear();
//      verification
        verify(mlist).add(1);
        verify(mlist).clear();
    }

    /**
     * 返回期望值
     */
    @Test
    public void testStubb(){

        LinkedList mlist = mock(LinkedList.class);
//      设置期望值  stubbing。当get(0)被调用时，返回"first". 方法get(1)被调用时，抛异常。
        when(mlist.get(0)).thenReturn("first");
        when(mlist.get(1)).thenReturn(new RuntimeException());
//      执行验证期望值
        System.out.println(mlist.get(0));
        System.out.println(mlist.get(1));
//        执行非期望值的内容
        System.out.println(mlist.get(3));
    }

    /**
     * 多次调用返回不同结果
     */
    @Test
    public void testStubb2(){
        LinkedList mlist = mock(LinkedList.class);
        when(mlist.get(0)).thenReturn("first").thenReturn("second");
        System.out.println(mlist.get(0));
        System.out.println(mlist.get(0));
    }

    @Test
    public void testStubb3(){
        File mfile = mock(File.class);
        when(mfile.renameTo(argThat(new IsAnyFiles()))).thenReturn(false);
        mfile.renameTo(new File("test"));

        verify(mfile).renameTo(argThat(new IsAnyFiles()));
    }

    class IsAnyFiles extends ArgumentMatcher<File> {
        public boolean matches(Object file) {
            return file.getClass() == File.class;
        }
    }

    @Test
    public void testVerify(){
//        验证被调用的次数
        List mlist = mock(List.class);
//        mlist.add("one");
//        mlist.add("two");
//        mlist.add("three");
//        verify(mlist,times(2));

//        verify(mlist,atLeastOnce());

        verify(mlist,atLeast(2));

    }

    @Test
    public void testDoThrow(){
//        调用方法时抛出异常
        doThrow(new RuntimeException()).when(mocklist).clear();
    }

    @Test
    public void testOrder(){
        inOrder().verify(mocklist).add("1");
    }




}
