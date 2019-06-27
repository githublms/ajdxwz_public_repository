import time
import stomp

class MyListener(object):
    def on_error(self, headers, message):
        print('received an error %s' % message)

    def on_message(self, headers, message):
        print('received a message %s' % message)

# 官方示例的连接代码也落后了，现在分协议版本
conn = stomp.Connection10([('192.168.31.201', 61613)])
conn.set_listener('', MyListener())
conn.start()
conn.connect()

# conn.subscribe(destination='/queue/test', id=1, ack='auto')
# 注意，官方示例这样发送消息是有问题的
# conn.send(body='hello,garfield! this is '.join(sys.argv[1:]), destination='/queue/test')
while True:
    conn.send(body=' data 1 ', destination='/queue/wwwqq')
    print("每间隔2秒就发送了数据，我是生产者1")
    time.sleep(2)
conn.disconnect()
