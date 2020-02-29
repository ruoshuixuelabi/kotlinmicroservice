package io.kang.oss

import com.aliyun.oss.OSS
import com.aliyun.oss.common.utils.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.RestController
import org.springframework.core.io.WritableResource
import org.springframework.web.bind.annotation.GetMapping
import org.apache.commons.codec.CharEncoding
import org.springframework.util.StreamUtils
import java.nio.charset.Charset


@RestController
class OssController {
    @Autowired
    lateinit var ossClient: OSS

    @Value("classpath:/oss-test.json")
    lateinit var localFile: Resource

    @Value("oss://kcglobal/test/oss-test.json")
    lateinit var remoteFile: Resource

    @GetMapping("/upload")
    fun upload(): String {
        try {
            ossClient.putObject("kcglobal", "test/oss-test.json", this.javaClass.classLoader.getResourceAsStream("oss-test.json"))
        } catch (e: Exception) {
            e.printStackTrace()
            return "upload fail: " + e.message
        }

        return "upload success"
    }

    @GetMapping("/file-resource")
    fun fileResource(): String {
        try {
            return "get file resource success. content: " + StreamUtils.copyToString(
                    remoteFile.inputStream, Charset.forName(CharEncoding.UTF_8))
        } catch (e: Exception) {
            e.printStackTrace()
            return "get resource fail: " + e.message
        }

    }

    @GetMapping("/download")
    fun download(): String {
        try {
            val ossObject = ossClient.getObject("kcglobal",
                    "test/oss-test.json")
            return "download success, content: " + IOUtils
                    .readStreamAsString(ossObject.objectContent, CharEncoding.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            return "download fail: " + e.message
        }

    }

    @GetMapping("/upload2")
    fun uploadWithOutputStream(): String {
        try {
            (this.remoteFile as WritableResource)
                    .outputStream.use { outputStream -> localFile.inputStream.use { inputStream -> StreamUtils.copy(inputStream, outputStream) } }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return "upload with outputStream failed"
        }

        return "upload success"
    }
}