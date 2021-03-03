package edu.scs.vds.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class S3FileUploaderService {
    @Value("${s3.bucketName}")
    private String bucketName;
    @Value("${s3.rootUrl}")
    private String rootUrl;

    public String fileUploader(MultipartFile multipartFile, String folder) throws IOException {
        AmazonS3 s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
        try {
            final String filePath = (folder + "/" + new Date().getTime() + "_" + multipartFile.getOriginalFilename());
            S3Object s3Object = new S3Object();
            ObjectMetadata omd = new ObjectMetadata();
            omd.setContentType(multipartFile.getContentType());
            omd.setContentLength(multipartFile.getSize());
            omd.setHeader("filename", multipartFile.getName());

            ByteArrayInputStream bis = new ByteArrayInputStream(multipartFile.getBytes());

            s3Object.setObjectContent(bis);
            PutObjectResult putObjectResult = s3.putObject(new PutObjectRequest(bucketName, filePath, bis, omd));
            s3Object.close();

            return rootUrl + filePath;
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered an internal error while trying to communicate with S3, such as not being able to access the network.");
        } catch (Exception e) {
            System.out.println("Error Message:    " + e.getMessage());
        }
        return null;
    }
}