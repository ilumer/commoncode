/**
 * Created by ilumer
 * Date : 2019-05-22
 * Time : 00:50
 */
// 测试结果
// oneToMany的单向关系比双向关系多出对于中间表部分的维护 所以在删除和新建时 性能上不如双向关系
// 使用ManyToOne的单向是不是比以上更好