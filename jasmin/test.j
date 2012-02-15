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
  iload 0
  ldc 4
  invokespecial Test/test(I)V
  return
.end method

.method private test(I)V
  .limit stack 16
  .limit locals 5

  return
.end method

