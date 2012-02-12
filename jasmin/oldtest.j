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
     ; push java.lang.System.out (type PrintStream)
   getstatic java/lang/System/out Ljava/io/PrintStream;
   
   ; push string to be printed
   ldc "Hello World"
   
   ; invoke println
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
  return
.end method
