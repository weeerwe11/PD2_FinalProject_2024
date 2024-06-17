//一個任務管理器，能夠記錄每天的行程

//基本功能：將使用者輸入的行程按日期存入各自的帳號中(如 userA.txt、userB.txt)，可以自由喚出、刪改行程

//日程格式：
0101    do_something
->date  ->schedule

//功能：
帳號相關：
1.註冊自己的日記(日記_UserName.txt)
2.進入或切換不同使用者的日記(登入)
操作相關：
1.按輸入日期查詢日程
2.按輸入日程查詢日期
3.輸出日記中所有日程
4.加入日程
5.刪除日程

//分工
    讀取、輸出檔案相關：林欣懋
    FileRelated
        parse-讀入日記
        create-創建對應帳號的日記
    帳戶相關：林欣懋
    AccountRelated
        SignUp-註冊
        LogIn-登入
        exist-檢查帳號是否已經存在
    操作相關：林欣懋
    OperationRelated
        DQuery-用日期查日程
        SQuery-用日程查日期
        allOut-印出所有日程
        add-加入日程
        delete-刪除日程
