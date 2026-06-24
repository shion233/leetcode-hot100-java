# LeetCode Hot 100 Java 刷题记录 / Java Solutions

这个仓库用于记录我的 LeetCode Hot 100 Java 题解。每道题的 `Solution.java` 或相关类文件中都补充了“做题思路”，其中被注释掉的代码通常是我的最初解法，当前未注释代码是后续优化后的版本。

This repository contains my Java solutions for LeetCode Hot 100. Each problem file includes a Chinese thought-process comment. Commented-out code usually represents my original approach, while the active code is the improved version.

## 项目结构 / Project Structure

```text
leetcode-hot100-java/
├── README.md
├── hash/                   # 哈希 / Hash
├── two_pointers/           # 双指针 / Two Pointers
├── sliding_window/         # 滑动窗口 / Sliding Window
├── substring/              # 子串 / Substring
├── array/                  # 普通数组 / Array
├── matrix/                 # 矩阵 / Matrix
├── linked_list/            # 链表 / Linked List
├── binary_tree/            # 二叉树 / Binary Tree
├── graph/                  # 图论 / Graph
├── backtracking/           # 回溯 / Backtracking
├── binary_search/          # 二分查找 / Binary Search
├── stack/                  # 栈 / Stack
├── heap/                   # 堆 / Heap
├── greedy/                 # 贪心算法 / Greedy
├── dynamic_programming/    # 动态规划 / Dynamic Programming
├── multidimensional_dp/    # 多维动态规划 / Multidimensional DP
└── techniques/             # 技巧 / Techniques
```

## 题目分类 / Problem Categories

| 分类 / Category | 题目 / Problems |
| --- | --- |
| 哈希 / Hash | 字母异位词分组, 128. 最长连续序列 |
| 双指针 / Two Pointers | 11. 盛最多水的容器, 15. 三数之和, 42. 接雨水, 283. 移动零 |
| 滑动窗口 / Sliding Window | 3. 无重复字符的最长子串, 438. 找到字符串中所有字母异位词 |
| 子串 / Substring | 76. 最小覆盖子串, 239. 滑动窗口最大值, 560. 和为 K 的子数组 |
| 普通数组 / Array | 41. 缺失的第一个正数, 53. 最大子数组和, 56. 合并区间, 189. 轮转数组, 238. 除了自身以外数组的乘积 |
| 矩阵 / Matrix | 48. 旋转图像, 54. 螺旋矩阵, 73. 矩阵置零, 240. 搜索二维矩阵 II |
| 链表 / Linked List | 2. 两数相加, 19. 删除链表的倒数第 N 个结点, 21. 合并两个有序链表, 23. 合并 K 个升序链表, 24. 两两交换链表中的节点, 25. K 个一组翻转链表, 138. 随机链表的复制, 141. 环形链表, 142. 环形链表 II, 146. LRU 缓存, 148. 排序链表, 160. 相交链表, 206. 反转链表, 234. 回文链表 |
| 二叉树 / Binary Tree | 94. 二叉树的中序遍历, 98. 验证二叉搜索树, 101. 对称二叉树, 102. 二叉树的层序遍历, 104. 二叉树的最大深度, 105. 从前序与中序遍历序列构造二叉树, 108. 将有序数组转换为二叉搜索树, 114. 二叉树展开为链表, 124. 二叉树中的最大路径和, 199. 二叉树的右视图, 226. 翻转二叉树, 230. 二叉搜索树中第 K 小的元素, 236. 二叉树的最近公共祖先, 437. 路径总和 III, 543. 二叉树的直径 |
| 图论 / Graph | 200. 岛屿数量, 207. 课程表, 208. 实现 Trie 前缀树, 994. 腐烂的橘子 |
| 回溯 / Backtracking | 17. 电话号码的字母组合, 22. 括号生成, 39. 组合总和, 46. 全排列, 51. N 皇后, 78. 子集, 79. 单词搜索, 131. 分割回文串 |
| 二分查找 / Binary Search | 4. 寻找两个正序数组的中位数；33. 搜索旋转排序数组；34. 在排序数组中查找元素的第一个和最后一个位置；35. 搜索插入位置；74. 搜索二维矩阵；153. 寻找旋转排序数组中的最小值 |
| 栈 / Stack | 20. 有效的括号；84. 柱状图中最大的矩形；155. 最小栈；394. 字符串解码；739. 每日温度 |
| 堆 / Heap | 215. 数组中的第 K 个最大元素；295. 数据流的中位数；347. 前 K 个高频元素 |
| 贪心算法 / Greedy | 暂无 / None yet |
| 动态规划 / Dynamic Programming | 暂无 / None yet |
| 多维动态规划 / Multidimensional DP | 暂无 / None yet |
| 技巧 / Techniques | 暂无 / None yet |

## 运行 / Run

```bash
mvn test
```

The Maven configuration compiles Java files from the category folders above. Directory names use underscores instead of hyphens because Java package names cannot contain `-`.
