package tree.openglsk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * openGL 2.0 渲染管线
 * Api-->基本处理-->顶点着色器-->图元装饰-->光栅化——>片元着色器-->
 * 剪裁测试--->深度测试--->颜色缓冲混合-->抖动--->帧缓冲
 * Note:插值：用来填充图像变换时像素之间的空隙。https://baike.baidu.com/item/%E6%8F%92%E5%80%BC/1196063?fr=aladdin
 * <p>
 * A:基本处理
 * 设定3D 物体的顶点坐标 顶点颜色 顶点纹理 坐标等属性 指定绘制方式  点绘制 线段绘制 或者三角形 绘制
 *
 * B:顶点缓冲对象
 * 可选的 对于某些顶点基本不变的情况，在初始化阶段就可以把顶点数据传入 省去了每次都传入顶点消耗性能
 *
 * C:顶点着色器
 *  1.是一个可编程的处理单元，可以执行顶点的变换，光照 材质的应用于计算的相关操作 ，每个顶点执行一次
 *  2.将顶点几何信息以及其它属性传入顶点着色器--处理后-->产生纹理坐标，颜色，点 位置，等各种顶点属性--传给->图元装配阶段。
 *  3，着色器的工作原理
 *      顶点着色器的 输入：主要为待处理顶点相应的attribute(属性)变量，uniform(一致)变量，采样器以及临时变量，
 *                 输出：顶点着色器处理后生成的varying变量以及一些内建输出变量
 *                 attribute0       uniform  采样器        varying0
 *                 attribute1          ↓       ↓          varying1
 *                 attribute2 ---> 顶 点 着 色 器 -------> varying2
 *                 attribute3            ↕                varying3
 *                 attribute4        临时变量              varying4
 *                                           gl_Position
 *                                           gl_FrontFacing
 *                                           gl_PointSize
 *                1，attribute变量 。3D物体中顶点 位置，颜色 ，法向量 等每个顶点信息 都是以attribute 传入顶点着色器的
 *                2，uniform 变量 。 同一组顶点组成的3D物体中 各个顶点相同的信息，一般为 光源位置，当前摄像机 位置，投影系列举证
 *                3，varying变量 。 （易变变量）是从顶点着色器中计算产生的 并传递给图元着色器变量。顶点着色器可以使用varying来传递
 *                                 需要插值到片元的颜色，法向量，纹理坐标等
 *                4，gl_Position,gl_FrontFacint,gl_PointSize 等 内建输出变量
 *                   1，gl_Position是经过 变换矩阵·变换·投影 后的最终位置
 *                   2，gl_FrontFacing指的是片元所在面的朝向
 *                   3，gl_Position 是指的是点的大小
 *
 *               Note：varying 变量在顶点着色器赋值后“并不是”直接传入给片元着色器，而是在“光栅化”阶段由“管线”
 *                              根据片元所属图元各个顶点对应的顶点着色器 根据次变量的赋值情况及片元和各顶点的
 *                              位置关系产生插值 。
 *                              △ 根据各个定点的颜色 和位置关系 产生的 插值数据  传入了图元装饰
 *
 * D:图元装饰
 *    1，图元组装 顶点数据根据设置的绘制方式组成完成的图元。
 *       例如：点的绘制方式下每个图元仅需要一个顶点 顶点既是图元，线段绘制方式两个顶点绘制一个图元。
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
