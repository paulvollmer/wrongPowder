
wngConfig config = new wngConfig();


void setup() {
  // Load configuration File.  
  config.loadFile("wngMT", "config.txt");
  
  println(config.file);
  String[] appWidth = split(config.file[0], '=');
  String[] appHeight = split(config.file[1], '=');
  
  size(int(appWidth[1]), int(appHeight[1]));
  this.frame.setResizable(true);
}



void draw() {
}



void dispose() {
  String[] configSaver = new String[2];
  configSaver[0] = "appWidth="+width;
  configSaver[1] = "appHeight="+height;
  
  config.saveFile(configSaver);
  
  println("###");
}

void exit() {
  println("exit");
}

void close() {
  println("stop");
}
