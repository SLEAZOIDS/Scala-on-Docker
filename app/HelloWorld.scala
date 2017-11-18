object HelloWorld{
  def hello(args: Array[String]){
    if(args.size == 0) {
      val strs = Array("Hello ", "World", "\n")
      output(strs)
    } else {
      printf("Invalid args.")
    }
  }

  def output(strs: Array[String]){
    strs.foreach(printf("%s", _))
  }
}