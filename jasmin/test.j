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
  .limit locals 4
  ldc 7
  istore 1
  ldc 1
  istore 2
  ldc 0
  istore 3
 while1:
  iload 2
  iload 1
  if_icmple start1
  goto done1
 start1:
  aload 0
  iload 2
  invokevirtual Test/fibonacci(I)I
  istore 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload 2
  invokevirtual java/io/PrintStream/print(I)V
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc " : "
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload 3
  invokevirtual java/io/PrintStream/print(I)V
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "
"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  iload 2
  ldc 1
  iadd
  istore 2
  goto while1
 done1:
  return
.end method

.method private fibonacci(I)I
  .limit stack 16
  .limit locals 3
  ldc 0
  istore 2
  iload 1
  ldc 1
  if_icmple start2
  goto start3
 start3:
  aload 0
  iload 1
  ldc 1
  isub
  invokevirtual Test/fibonacci(I)I
  aload 0
  iload 1
  ldc 2
  isub
  invokevirtual Test/fibonacci(I)I
  iadd
  istore 2
  goto done2
 start2:
  iload 1
  istore 2
 done2:
  iload 2
  ireturn
.end method

