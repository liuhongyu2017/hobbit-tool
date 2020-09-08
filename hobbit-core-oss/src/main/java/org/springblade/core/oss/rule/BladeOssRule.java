package com.hobbit.core.oss.rule;

import lombok.AllArgsConstructor;
import com.hobbit.core.tool.utils.DateUtil;
import com.hobbit.core.tool.utils.FileUtil;
import com.hobbit.core.tool.utils.StringPool;
import com.hobbit.core.tool.utils.StringUtil;

/**
 * 默认存储桶生成规则
 *
 * @author Chill
 */
@AllArgsConstructor
public class BladeOssRule implements OssRule {

  @Override
  public String bucketName(String bucketName) {
    return bucketName;
  }

  @Override
  public String fileName(String originalFilename) {
    return "upload" + StringPool.SLASH + DateUtil.today() + StringPool.SLASH + StringUtil
        .randomUUID() + StringPool.DOT + FileUtil.getFileExtension(originalFilename);
  }

}
