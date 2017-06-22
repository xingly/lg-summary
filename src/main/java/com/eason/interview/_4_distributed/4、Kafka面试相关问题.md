
## 面试中Kafka相关几个典型问题

### 一. kafka如何实现高吞吐率

#### 1.系统级优化

- disk读取优化：随机读写满，顺序读写快；寻道时间

- os推测读写优化：read-ahead & write-ahead

- zero copy优化 & sendfile技术：减少字节copy；
```
文件->PageCache（内核缓存区） -> User buffer（用户缓存区） -> Socket Buffer -> NIC（网卡缓冲区） Buffer
文件 -> PageCache -> NIC Buffer
```
- tcp参数优化：调整缓存区大小，滑动窗口等

- Append message：顺序读写msgs数据

#### 2.应用级优化
- broker

- producer

- consumer


### 二. kafka机器挂掉如何保证pagecache消息不丢
修改确认为-1，保证写入所有follower成功，即使master挂了，新的master也有挂掉master未持久化的数据。保证数据不丢失。

### 三. kafka如何保存数据
分区文件夹 .index文件索引offset位置
前一个最大offset命名下一个.log段文件

### 四. leader选举算法
isr（in—sync replica）同步副本集中选取


### 五. Kafka的选举算法和zk的选举算法有何不同，为什么这种选择？


### 六. kafka consumer负载均衡算法
