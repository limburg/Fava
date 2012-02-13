.class public Test
.super java/lang/Object
.method public <init>()V
  aload_0 ; push this
  invokespecial java/lang/Object/<init>()V ; call super
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 2
  new Test
  dup
  invokespecial Test/<init>()V
  invokevirtual Test/main()V
  return
.end method
.method public main()V
  .limit stack 16
  .limit locals 1
  aload 0
  invokevirtual Test/test()V
  return
.end method

.method private test()V
  .limit stack 16
  .limit locals 3
  ldc 0
  istore 0
  ldc 0
  istore 1
 while0:
  iload 0
  ldc 5
  isub
  ifge done0
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "x"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  iload 0
  ldc 1
  iadd
  istore 0
  goto while0
 done0:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc " finished
"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
 while1:
  iload 1
  ldc 0
  isub
  ifne done1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "o"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 1
  istore 1
  goto while1
 done1:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc " finished
"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  return
.end method

