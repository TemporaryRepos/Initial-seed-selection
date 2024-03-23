# Selecting Initial Seeds for Better JVM Fuzzing

This is the implementation of our ICSE 2025 paper.

### I. Introduction

JVM fuzzing techniques serve as a cornerstone for guaranteeing the quality of implementations. In typical fuzzing workflows, initial seeds are crucial as they form the basis of the process. Literature in traditional program fuzzing has confirmed that effectiveness is largely impacted by redundancy among initial seeds, thereby proposing a series of seed selection methods. JVM fuzzing, compared to traditional ones, presents unique characteristics, including large-scale and intricate code, and programs with both syntactic and semantic features. However, it remains unclear whether the existing initial seed selection methods are suitable for JVM fuzzing and whether utilizing program features can enhance effectiveness. To address this, we devised a total of 10 initial seed selection methods, comprising coverage-based, prefuzz-based, and program-feature-based methods. We then conducted an empirical study on three JVM implementations to extensively evaluate the performance of the initial seed selection methods within two state-of-the-art fuzzing techniques (JavaTailor and VECT). Specifically, we examine performance from three aspects: (i) effectiveness and efficiency using widely studied initial seeds, (ii) effectiveness using the programs in the wild, and (iii) the ability to detect new bugs. 

Evaluation results first show that the program-feature-based method that utilizes the control flow graph not only has a significantly lower time overhead (i.e., 30s), but also outperforms other methods, achieving 142% to 269% improvement compared to the full set of initial seeds. Second, results reveal that the initial seed selection greatly improves the quality of wild programs and exhibits complementary effectiveness by detecting new behaviors. Third, results demonstrate that given the same testing period, initial seed selection improves the JVM fuzzing techniques by detecting more unknown bugs. Particularly, 16 out of the 25 detected bugs have been confirmed or fixed by developers. This work takes the first look at initial seed selection in JVM fuzzing, confirming its importance in fuzzing effectiveness and efficiency.

Table 1 shows the comparison results of each method in terms of unique inconsistencies in the differential testing. The FullSet and RandomSet in the first column represent the use of the entire set of initial seeds and the subset selected by random selection, serving as baselines for comparison. Results highlighted in bold indicate superior performance compared to the FullSet. The top three performing methods are shaded, with darker shades indicating better performance.

<p align="center">Table 1: Comparison results of different methods in terms of the number of unique inconsistencies</p>

![image-20240323154303781](https://ningmo.oss-cn-beijing.aliyuncs.com/img/image-20240323154303781.png)

### II. Preparation Work

##### 1: Import as an maven project

This is developed as an maven project, so you can directly load the project using IntelliJ IDEA workspace to build the environment.

##### 2: Download Data

Because the size of the data is large, we do not provide test subjects in this repo, so you need to download data from google drive.

### III. Getting Started

We provide the source files and jar packages for the project. You can make changes in the source code, or just use the jar to execute the project directly. 

