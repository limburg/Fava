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
  ldc 4
  invokevirtual Test/test(I)V
  return
.end method

.method private test(I)V
  .limit stack 16
  .limit locals 4
  aload 0
  ldc ","
  astore 2
  ldc 0
  istore 3
 while1:
  iload 3
  iload 1
  if_icmple start1
  goto done1
 start1:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc 1
  iload 3
  ldc 3
  imul
  iadd
  invokevirtual java/io/PrintStream/print(I)V
  getstatic java/lang/System/out Ljava/io/PrintStream;
  new java/lang/StringBuffer
  dup
  invokespecial java/lang/StringBuffer/<init>()V
  aload 2
  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  new java/lang/StringBuffer
  dup
  invokespecial java/lang/StringBuffer/<init>()V
  ldc " hmm"
  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  ldc " daa "
  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;
  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  iload 3
  ldc 1
  iadd
  istore 3
  goto while1
 done1:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc " finished
"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  return
.end method

