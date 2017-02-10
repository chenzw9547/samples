
## Algorithm Samples:
## 1. [丢失的字母](src/main/java/cn/chenzw/simple_algorithm/dothers)：

一个数组存储很多英文字母，问：怎么知道26个字母中哪些没有存储？

**思路: ** 将每个字母转换成数组的下标，并对出现的次数自增，因为字母是连续的，所以数组项值为0的数组下标值即为未存储的字母
