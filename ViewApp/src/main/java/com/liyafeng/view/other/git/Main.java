package com.liyafeng.view.other.git;

public class Main {

    /**
     * github新建个Repository，然后本地git init 一个仓库
     * 本地添加远程 git remote add origin git@github.com:pop1234o/Algorithm.git
     * git pull orgin
     * <p>
     * git remote add [name] [url] //添加一个远程仓库
     * git pull [name]
     * <p>
     * git push
     * <p>
     * git 查看修改 git diff
     * git 查看状态 git status
     * <p>
     * git丢弃工作区 git checkout .
     * <p>
     * git添加 git add .
     * git 提交 git commit -m"aa"
     * git 推送 git push 远程名称 （不写默认是关联的远程分支）
     * <p>
     * git push --set-upstream origin master (如果没有关联则要关联一下)
     * <p>
     * <p>
     * 添加一个远程仓库
     * git remote add 远程名称 地址
     * git remote remove 删除远程
     * <p>
     * 更新远程仓库的分支信息
     * git remote update [-p] [remote]
     * -p代表prune 更新同时删除远程已经删除的分支的本地关联
     * <p>
     * 从远程拉取 到当前分支！
     * git pull 远程名 分支 （默认是关联的分支拉）
     * <p>
     * 关联的远程的仓库一般是一个origin和一个upstream
     * <p>
     * 删除本地分支
     * git branch -d 分支名
     * <p>
     * 拉取远程分支到本地 创建的一个新分支，并切换到这个分支
     * git checkout -b  本地新分支名  remote仓库名/远程分支名
     * -b代表 new_Branch的意思
     * <p>
     * 推送本地分支到远程（并 创建远程分支 然后关联）
     * git push -u 远程仓库名 分支名
     * 这里要用空格分割！
     * -u 代表关联 ，- set_Upstream
     * <p>
     * <p>
     * 查看当前分支的commit
     * git log [文件名]
     * <p>
     * -----------------------
     * git 初始化，我们提交代码要设置 用户名 和 邮箱
     * <p>
     * git config --global user.name "John Doe"
     * git config --global user.email johndoe@example.com
     * 这个要设置，否则commit记录那个色块就没有了
     * <p>
     * 这时时编辑的是用户目录下的 .gitconfig 文件
     * 查看git 配置
     * git config --list
     * <p>
     * 我们这里还可以指定文本编辑器，和差异比较工具
     * <p>
     * >参考 https://git-scm.com/book/zh/v1/起步-初次运行-Git-前的配置
     * <p>
     * ---
     * 新建分支
     * https://git-scm.com/book/zh/v1/Git-分支-分支的新建与合并
     * <p>
     * git checkout -b [name]  //新建本地分支
     * //相当于
     * git branch [name]
     * git checkout [name]
     * <p>
     * <p>
     * git branch   //查看本地分支
     * //本地分支推送到远程，相当于远程新建了一个分支
     * git push origin branch_fast:branch_fast
     * //查看所有分支
     * git branch -a
     * <p>
     * //查看远程分支
     * git branch -r
     * <p>
     * git branch -vv查看当前本地分支关联的远程分支
     * <p>
     * =================
     * 取消当前分支和远程分支的关联
     * git branch --unset-upstream master
     * <p>
     * <p>
     * git branch --set-upstream origin/master
     * <p>
     * ==================
     * 创建一个新的本地分支，并关联到远程
     * git checkout -b 分支名
     * 这样就创建了一个新的分支，并且切换到那个分支，这个分支的代码和你当前分支是一样的
     * 然后你git push -u origin 远程分支名
     * 这样远程就会创建一个分支，并且与本地分支关联，以后修改代码就直接
     * git push就能自动推送到 origin/分支名 中了。
     * <p>
     * ====================
     * 在git reomote add origin 地址.git 后，添加了远程仓库
     * 然后需要fetch一下才能获取到远程仓库的信息
     * git fetch origin ，这样就把远程仓库获取到本地了
     * 这个时候我们可以本地代码分支关联到远程了
     * 当前我们可以获取拉取本地没有的远程分支，并且关联
     * <p>
     * git checkout -b branch1.1 origin/branch1.1
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * Command line instructions
     * <p>
     * <p>
     * Git global setup
     * <p>
     * git config --global user.name "pop"
     * git config --global user.email "859405648@qq.com"
     * <p>
     * Create a new repository
     * <p>
     * git clone http://code.jiaoyinhudong.com/baoguan/Android-InsurView.git
     * cd Android-InsurView
     * touch README.md
     * git add README.md
     * git commit -m "add README"
     * git push -u origin master
     * <p>
     * Existing folder  存在工程，但是没有关联仓库
     * <p>
     * cd existing_folder
     * git init
     * git remote add origin http://code.jiaoyinhudong.com/baoguan/Android-InsurView.git
     * git add .
     * git commit -m "Initial commit"
     * git push -u origin master
     * <p>
     * Existing Git repository 已经存在了一个仓库
     * <p>
     * cd existing_repo
     * git remote rename origin old-origin
     * git remote add origin http://code.jiaoyinhudong.com/baoguan/Android-InsurView.git
     * git push -u origin --all
     * git push -u origin --tags
     */
    void a1() {
    }
}
